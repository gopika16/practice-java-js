namespace PracticeFirstApp.Services.Dtos;

public class SecurityDto
{
    public int Id { get; set; }
    public required string Name { get; set; }
    public int SecurityId { get; set; }
    public required string Symbol { get; set; }
    public bool IsMacsecurity { get; set; }
    public int? SecuritySetId { get; set; }
    public string? SecuritySetName { get; set; }
}
