using MediatR;
using PracticeFirstApp.Services.Constants;
using PracticeFirstApp.Services.Dtos;

namespace PracticeFirstApp.Services.Features.Trade;

public abstract class GetTrade
{
    public class Query : IRequest<TradeDto>
    {
        public readonly int Id;
        public readonly int SecurityId;
        public readonly int AccountId;
        public readonly int TradeInstanceId;
        public readonly string Custodian;
        public readonly int CustodianId;
        public readonly int TradeAmount;
        public readonly string TradeAction;
        public readonly DateTime CreatedDate;
        public readonly bool IsEnabled;
        public readonly int OrderQuantity;
        public readonly float OrderPercent;
        public readonly string? Status;

        public Query(string tradeAction)
        {
            Id = DefaultMessages.Trade.One;
            SecurityId = DefaultMessages.Trade.One;
            AccountId = DefaultMessages.Trade.One;
            TradeInstanceId = DefaultMessages.Trade.One;
            Custodian = DefaultMessages.Trade.Custodian;
            CustodianId = DefaultMessages.Trade.One;
            TradeAmount = DefaultMessages.Trade.Hundred;
            TradeAction = tradeAction;
            IsEnabled = true;
            OrderQuantity = DefaultMessages.Trade.One;
            OrderPercent = DefaultMessages.Trade.Twenty;
        }
    }

    public class Handler : IRequestHandler<Query, TradeDto>
    {
        public Task<TradeDto> Handle(Query request, CancellationToken cancellationToken)
        {
            TradeDto trade = new TradeDto
            {
                Id = request.Id,
                SecurityId = request.SecurityId,
                AccountId = request.AccountId,
                TradeInstanceId = request.TradeInstanceId,
                Custodian = request.Custodian,
                CustodianId = request.CustodianId,
                TradeAmount = request.TradeAmount,
                TradeAction = request.TradeAction,
                IsEnabled = request.IsEnabled,
                OrderQuantity = string.Equals(request.TradeAction, DefaultMessages.Trade.Buy, StringComparison.OrdinalIgnoreCase) ? request.OrderQuantity : -request.OrderQuantity,
                OrderPercent = request.OrderPercent
            };
            return Task.FromResult(trade);
        }
    }
}
