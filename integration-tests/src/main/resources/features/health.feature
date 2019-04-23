Feature: transaction-processor health endpoint

  Scenario: transaction-processor health check
    When making a request to transaction-processor:8080/health
    Then response for .status is UP
