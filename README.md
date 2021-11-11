# API 설명

***사용자 관리 관련***
```
@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 닉네임 중복 체크
    @GetMapping("/redundant")
    public boolean isRedundant(@RequestParam String nickname) {
        return authService.isRedundant(nickname);
    }

    // 회원 가입
    @PostMapping("/register")
    public Long registerUser(@RequestBody RegisterUserRequestDto requestDto) {
        return authService.registerUser(requestDto);
    }

    // 로그인
    @PostMapping("/login")
    public Long login(@RequestBody LoginRequestDto requestDto) {
        return authService.login(requestDto);
    }
}
```

***포트폴리오 관련***
```
@RequestMapping("/api/v1/portfolio/")
@RequiredArgsConstructor
@RestController
public class PortfolioController {

    private final PortfolioService portfolioService;

    // 종목별 종가 데이터 조회
    @GetMapping("/stock/price/{stockCode}")
    public List<StockClosingPriceListResponseDto> getStockPrice(@PathVariable Long stockCode) {
        return portfolioService.getStockPrice(stockCode);
    }

    // 개인별 계좌 조회
    @GetMapping("/account/{userId}")
    public List<AccountResponseDto> getAccount(@PathVariable Long userId) {
        return portfolioService.getAccount(userId);
    }
}
```

***댓글(종목 게시판) 관련***
```
@RequestMapping("/api/v1/comment/")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    // 종목별 댓글 수익금 순으로 불러오기
    @GetMapping("/{code}")
    public List<CommentListResponseDto> getStockCommentAll(@PathVariable Long code) {
        return commentService.getStockCommentAll(code);
    }

    // 주주인지 체크
    @GetMapping("/transaction")
    public boolean isZoozoo(@RequestParam Long userId,@RequestParam Long stockCode) {
        return commentService.isZoozoo(userId, stockCode);
    }

    // 댓글 입력
    @PostMapping("/")
    public Long saveComment(@RequestBody CommentSaveRequestDto requestDto) {
        return commentService.saveComment(requestDto);
    }

    // 댓글 매수 매도 내역
    @GetMapping("/transaction/{commentId}")
    public List<TransactionListResponseDto> getTransactionList(@PathVariable Long commentId) {
        return commentService.getTransactionList(commentId);
    }
    
    // 댓글 매수 매도 내역
    @GetMapping("/transaction/{commentId}")
    public List<TransactionListResponseDto> getTransactionList(@PathVariable Long commentId) {
        return commentService.getTransactionList(commentId);
    }

    // 종목 전체 조회
    @GetMapping("/stock")
    public List<StockListResponseDto> getStockAll() {
        return commentService.getStockAll();
    }

    // 종목 검색
    @GetMapping("/stock/search")
    public StockSearchResponseDto searchStock(@RequestParam String stockName) {
        return commentService.searchStock(stockName);
    }
}
```


-------------------------------------------------------------------------------


# RequestDto 설명

***CommentSaveRequestDto***
```
{
    "content" : "내용",
    "nickname" : "닉네임",
    "stockCode" : "종목코드"
}
```

***LoginRequestDto***
```
{
    "id" : "아이디",
    "password" : "비밀번호"
}
```

***RegisterUserRequestDto***
```
{
    "nickname" : "닉네임",
    "brokerage" : "증권사",
    "accountNumber" : "계좌번호",
    "id" : "아이디",
    "password" : "비밀번호"
}
```
