using MediatR;
using PracticeFirstApp.Services.Constants;
using PracticeFirstApp.Services.Dtos;

namespace PracticeFirstApp.Services.Features.Trade;

public abstract class SaveTrade
{
    public class Command : IRequest<TradeDto>
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

        public Command(TradeDto tradeDto)
        {
            Id = tradeDto.Id;
            SecurityId = tradeDto.SecurityId;
            AccountId = tradeDto.AccountId;
            TradeInstanceId = tradeDto.TradeInstanceId;
            Custodian = tradeDto.Custodian;
            CustodianId = tradeDto.CustodianId;
            TradeAmount = tradeDto.TradeAmount;
            TradeAction = tradeDto.TradeAction;
            IsEnabled = tradeDto.IsEnabled;
            OrderQuantity = tradeDto.OrderQuantity;
            OrderPercent = tradeDto.OrderPercent;
        }
    }

    public class Handler : IRequestHandler<Command, TradeDto>
    {
        public Task<TradeDto> Handle(Command request, CancellationToken cancellationToken)
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
                OrderPercent = request.OrderPercent,
                Status = request.IsEnabled ? DefaultMessages.Trade.IsEnabled : DefaultMessages.Trade.IsDisabled
            };
            return Task.FromResult(trade);
        }
    }
}
