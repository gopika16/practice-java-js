using MediatR;
using PracticeFirstApp.Services.Dtos;

namespace PracticeFirstApp.Services.Features;

public abstract class GetAccount
{
    public class Query : IRequest<AccountDto>
    {
        public readonly int Id;
        public readonly string AccountName;

        public Query(AccountDto accountDto)
        {
            Id = accountDto.Id;
            AccountName = accountDto.AccountName;
        }
    }

    public class Handler : IRequestHandler<Query, AccountDto>
    {
        public Task<AccountDto> Handle(Query request, CancellationToken cancellationToken)
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
