using MediatR;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;
using PracticeFirstApp.Services.Dtos;
using PracticeFirstApp.Services.Features.Trade;

namespace PracticeFirstApp.WebApi.Controller.Trade;

[EnableCors]
public class TradeController : ControllerBase
{
    private readonly IMediator _mediator;

    public TradeController(IMediator mediator)
    {
        _mediator = mediator;
    }

    public async Task<ActionResult<TradeDto>> GetTrade(string tradeAction)
    {
        Console.WriteLine("WElcome to backend");
        var trade = await _mediator.Send(new GetTrade.Query(tradeAction));
        return Ok(trade);
    }

    public async Task<ActionResult<TradeDto>> SaveTrade([FromBody] TradeDto tradeDto)
    {
        var trade = await _mediator.Send(new SaveTrade.Command(tradeDto));
        return Ok(trade);
    }
}
