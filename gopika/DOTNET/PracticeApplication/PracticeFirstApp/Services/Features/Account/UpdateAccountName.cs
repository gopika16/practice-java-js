using MediatR;
using PracticeFirstApp.Services.Dtos;

namespace PracticeFirstApp.Services.Features;

public abstract class UpdateAccountName
{
    public class Command : IRequest<AccountDto>
    {
        public readonly int Id;
        public readonly string AccountName;
        public Command(AccountDto accountDto, string lastname)
        {
            Id = accountDto.Id;
            AccountName = string.Concat(accountDto.AccountName, lastname);
        }
    }

    public class Handler : IRequestHandler<Command, AccountDto>
    {
        public Task<AccountDto> Handle(Command request, CancellationToken cancellationToken)
        {
            var account = new AccountDto
            {
                Id = request.Id,
                AccountName = request.AccountName
            };
            return Task.FromResult(account);
        }
    }
}
