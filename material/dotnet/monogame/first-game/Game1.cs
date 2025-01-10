using System;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;
using Microsoft.Xna.Framework.Media;

namespace first_game;

public class Game1 : Game
{
  private Rectangle _player, _level1Map;
  private bool _isDead = false;
  private Rectangle[] _goombas = {
    new(200, 70, 30, 30),
    new(410, 70, 30, 30),
    new(500, 130, 30, 30),
  };
  private Texture2D _playerTexture, _goombaTexture, _playerDeadTexture, _bg1CollisionTexture, _bg1Texture;
  private Color[] _mapCollisionColors;
  private GraphicsDeviceManager _graphics;
  private SpriteBatch _spriteBatch;
  private Rectangle[] _level1Rectangles;

  private Song _mainMusic;

  public Game1()
  {
    _graphics = new GraphicsDeviceManager(this);
    Content.RootDirectory = "Content";
    IsMouseVisible = true;
    _player = new(50, 50, 30, 70);
    _level1Map = new(0, 200, 709, 278);
    _level1Rectangles = new Rectangle[]{
      // sol
      new(0, 400, 690, 40),
      // colonne en jaune
      new(520, 200, 60, 150)
    };
  }

  protected override void Initialize()
  {
    // TODO: Add your initialization logic here

    base.Initialize();
  }

  protected override void LoadContent()
  {
    _spriteBatch = new SpriteBatch(GraphicsDevice);
    _playerTexture = Content.Load<Texture2D>("mario-pose-1");
    _goombaTexture = Content.Load<Texture2D>("goomba-pose-1");
    _playerDeadTexture = Content.Load<Texture2D>("mario-pose-mort");
    _bg1CollisionTexture = Content.Load<Texture2D>("level1-collisions");
    _mapCollisionColors = new Color[_bg1CollisionTexture.Width * _bg1CollisionTexture.Height];
    _bg1CollisionTexture.GetData<Color>(_mapCollisionColors);
    _bg1Texture = Content.Load<Texture2D>("level1-map");
    _mainMusic = Content.Load<Song>("music");
    MediaPlayer.Play(_mainMusic);
    MediaPlayer.IsRepeating = true;
  }

  protected override void Update(GameTime gameTime)
  {
    if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed || Keyboard.GetState().IsKeyDown(Keys.Escape))
      Exit();

    int deltaX = 0;
    int deltaY = 0;

    if (GamePad.GetState(PlayerIndex.One).DPad.Left == ButtonState.Pressed || Keyboard.GetState().IsKeyDown(Keys.Left))
      deltaX -= 3;
    else if (GamePad.GetState(PlayerIndex.One).DPad.Right == ButtonState.Pressed || Keyboard.GetState().IsKeyDown(Keys.Right))
      deltaX += 3;

    if (GamePad.GetState(PlayerIndex.One).DPad.Down == ButtonState.Pressed || Keyboard.GetState().IsKeyDown(Keys.Down))
      deltaY += 3;

    else if (GamePad.GetState(PlayerIndex.One).DPad.Up == ButtonState.Pressed || Keyboard.GetState().IsKeyDown(Keys.Up))
      deltaY -= 3;

    _player.X += deltaX;
    foreach (var wall in _level1Rectangles)
    {
      if (_player.Intersects(wall))
      {
        _player.X -= deltaX;
        break;
      }
    }
    _player.Y += deltaY;
    foreach (var wall in _level1Rectangles)
    {
      if (_player.Intersects(wall))
      {
        _player.Y -= deltaY;
        break;
      }
    }


    _isDead = false;
    foreach (var goomba in _goombas)
    {
      if (_player.Intersects(goomba))
      {
        _isDead = true;
        break;
      }
    }

    base.Update(gameTime);
  }

  protected override void Draw(GameTime gameTime)
  {
    GraphicsDevice.Clear(Color.CornflowerBlue);

    _spriteBatch.Begin();
    _spriteBatch.Draw(_isDead ? _playerDeadTexture : _playerTexture, this._player, Color.White);
    foreach (var goomba in _goombas)
    {
      _spriteBatch.Draw(_goombaTexture, goomba, Color.White);
    }

    foreach (var wall in _level1Rectangles)
    {
      _spriteBatch.Draw(_goombaTexture, wall, Color.White);
    }
    _spriteBatch.Draw(_bg1Texture, _level1Map, Color.White);
    _spriteBatch.End();
    base.Draw(gameTime);
  }
}
