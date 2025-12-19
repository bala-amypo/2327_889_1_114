public interface TokenRepository extends JpaRepository<BreachAlert, Long> {
    Optional<BreachAlert> findByTokenNumber(String tokenNumber);
}
