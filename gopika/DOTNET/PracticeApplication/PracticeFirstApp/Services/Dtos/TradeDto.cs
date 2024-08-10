namespace PracticeFirstApp.Services.Dtos;

public class TradeDto
{
    public int Id { get; set; }
    public int SecurityId { get; set; }
    public int AccountId { get; set; }
    public int TradeInstanceId { get; set; }
    public required string Custodian { get; set; }
    public int CustodianId { get; set; }
    public int TradeAmount { get; set; }
    public required string TradeAction { get; set; }
    public DateTime CreatedDate { get; set; }
    public bool IsEnabled { get; set; }
    public int OrderQuantity { get; set; }
    public float OrderPercent { get; set; }
    public string? Status { get; set; }
}