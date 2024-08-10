using MediatR;
using Microsoft.AspNetCore.Mvc;
using PracticeFirstApp.Services.Dtos;
using PracticeFirstApp.Services.Features;

namespace PracticeFirstApp.WebApi.Controller.Account;

public class AccountController : ControllerBase
{
    private readonly IMediator _mediator;

    public AccountController(IMediator mediator)
    {
        _mediator = mediator;
    }

    public async Task<ActionResult<AccountDto>> GetAccount([FromBody] AccountDto accountsDto)
    {
        var account = await _mediator.Send(new GetAccount.Query(accountsDto));
        return Ok(account);
    }

    public async Task<ActionResult<AccountDto>> UpdateAccountName([FromBody] AccountDto accountsDto, string lastName)
    {
        var account = await _mediator.Send(new UpdateAccountName.Command(accountsDto, lastName));
        return Ok(account);
    }
}
