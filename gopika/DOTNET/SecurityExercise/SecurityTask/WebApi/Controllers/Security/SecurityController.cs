using Microsoft.AspNetCore.Mvc;
using SecurityTask.Constants;
using SecurityTask.Dtos;

namespace SecurityTask.Controllers;

public class SecurityController : Controller
{
    public ActionResult<SecurityDto> Save([FromBody] SecurityDto securityDto)
    {
        return VerifySecurity(securityDto);
    }

    public ActionResult GetSecurityName([FromBody] SecurityDto securityDto)
    {
        var response = DefaultMessage.Security.Default;
        if (!VerifySecurity(securityDto).Equals(null))
        {
            var GetSecurityId = securityDto.SecurityId;
            if (GetSecurityId > 0)
            {
                response = securityDto.Name;
            }
            else
            {
                response = GetSecurityId.Equals(0) ? ErrorMessage.Security.ZeroSecurityId : ErrorMessage.Security.NegativeSecurityId;
            }
        }
        return Content(response);
    }

    public ActionResult<SecurityDto> VerifySecurity([FromBody] SecurityDto securityDto)
    {
        return securityDto.Equals(null) ? BadRequest(ErrorMessage.Security.SomethingWentWrong) : securityDto;
    }
}
