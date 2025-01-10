HeroWithConstructor heroWithConstructor = new(1, "garan", Role.Fighter);
HeroWithoutConstructor heroWithoutConstructor = new() { Id = 2, Name = "saraka", Role = Role.Spport };

public enum Role
{
  Fighter, Mage, Spport, Shooter
}

public class HeroWithConstructor
{
  public int Id { get; set; }
  public string Name { get; set; }
  public Role Role { get; set; }

  public HeroWithConstructor(int id, string name, Role role)
  {
    this.Id = id;
    this.Name = name;
    this.Role = role;
  }
}

public class HeroWithoutConstructor
{
  public required int Id { get; set; }
  public required string Name { get; set; }
  public required Role Role { get; set; }
}
