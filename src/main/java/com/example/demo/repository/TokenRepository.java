public interface TokenRepository extends JpaRepository<Token, Long> {
Optional<Token> findByTokenNumber(String tokenNumber);
List<Token> findByServiceCounter_IdAndStatusOrderByIssuedAtAsc(Long counterId, String status);
}