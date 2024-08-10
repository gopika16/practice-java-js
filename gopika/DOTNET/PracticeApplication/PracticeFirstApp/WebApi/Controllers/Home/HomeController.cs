using Microsoft.AspNetCore.Mvc;

namespace PracticeFirstApp.Controllers;

public class HomeController : Controller
{
    private string CustomMessage = "WELCOME";
    private readonly ILogger<HomeController> _logger;

    public HomeController(ILogger<HomeController> logger)
    {
        _logger = logger;
    }

    public string Index()
    {
        return CustomMessage;
    }
}
