# Backend

##포트폴리오 서비스 - base url : 3.35.205.126:8080/api/v1/portfolio/

1. 종목별 종가 데이터 조회
    @GetMapping("/stock/price/{stockCode}")
    public List<StockClosingPriceListResponseDto> getStockPrice(@PathVariable Long stockCode) {
        return portfolioService.getStockPrice(stockCode);
  
  -Get Method
  -stockCode를 url에 포함
  -종목별 종가 데이터가 List로 반환됨
  

2. 개인별 계좌 조회
    @GetMapping("/account/{userId}")
    public List<AccountResponseDto> getAccount(@PathVariable Long userId) {
        return portfolioService.getAccount(userId);
    }
  
  -Get Method
  -userId를 url에 포함
  -개인별 계좌에 보유중인 주식이 
