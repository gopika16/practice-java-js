// using MediatR;
// using Microsoft.AspNetCore.Mvc;
// using PracticeFirstApp.Services.Dtos;
// using PracticeFirstApp.Services.Features.Security;

// namespace PracticeFirstApp.WebApi.Controller.Security;

// public class SecurityController : ControllerBase
// {
//     private readonly IMediator _mediator;

//     public SecurityController(IMediator mediator)
//     {
//         _mediator = mediator;
//     }

//     public async Task<ActionResult<SecurityDto>> GetSecurityPrice(string SecuritySymbol)
//     {
//         var price = await _mediator.Send(new GetSecurityPrice.Query(SecuritySymbol));
//         return Ok(price);
//     }

//     public async Task<ActionResult<SecurityDto>> SaveTrade([FromBody] SecurityDto securityDto)
//     {
//         var updatedSecurityData = await _mediator.Send(new UpdateSecurityData.Command(securityDto));
//         return Ok(updatedSecurityData);
//     }s
// }
