var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();

List<Hero> heroes = [
  new() { Id = 1, Name = "garan", Role = Role.Fighter },
  new() { Id = 2, Name = "saraka", Role = Role.Spport },
];

app.MapGet("/heroes", () => heroes);
// Path parameter
app.MapGet("/heroes/{id}", (int id) => heroes[id]);
app.MapGet("/", () => "Hello World!");

app.Run();

public enum Role
{
  Fighter, Mage, Spport, Shooter
}
public class Hero
{
  public int Id { get; set; }
  public required string Name { get; set; }
  public required Role Role { get; set; }
}
