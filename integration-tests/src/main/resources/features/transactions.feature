Feature: transaction-processor CRUD endpoints

  Scenario: transaction-processor responds with empty data array if no transaction exist
    Given a request to transaction-processor
    Then response contains json
    """
    {"data":[]}
    """

  Scenario: transaction-processor responds with transaction json when adding new transaction
    Given a create request with data:
    """
    {
      "type": "Payment",
      "id": "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43",
      "version": 0,
      "organisation_id": "743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb",
      "attributes": {
        "amount": "100.21",
        "beneficiary_party": {
          "account_name": "W Owens",
          "account_number": "31926819",
          "account_number_code": "BBAN",
          "account_type": 0,
          "address": "1 The Beneficiary Localtown SE2",
          "bank_id": "403000",
          "bank_id_code": "GBDSC",
          "name": "Wilfred Jeremiah Owens"
        },
        "charges_information": {
          "bearer_code": "SHAR",
          "sender_charges": [
            {
              "amount": "5.00",
              "currency": "GBP"
            },
            {
              "amount": "10.00",
              "currency": "USD"
            }
          ],
          "receiver_charges_amount": "1.00",
          "receiver_charges_currency": "USD"
        },
        "currency": "GBP",
        "debtor_party": {
          "account_name": "EJ Brown Black",
          "account_number": "GB29XABC10161234567801",
          "account_number_code": "IBAN",
          "address": "10 Debtor Crescent Sourcetown NE1",
          "bank_id": "203301",
          "bank_id_code": "GBDSC",
          "name": "Emelia Jane Brown"
        },
        "end_to_end_reference": "Wil piano Jan",
        "fx": {
          "contract_reference": "FX123",
          "exchange_rate": "2.00000",
          "original_amount": "200.42",
          "original_currency": "USD"
        },
        "numeric_reference": "1002001",
        "payment_id": "123456789012345678",
        "payment_purpose": "Paying for goods/services",
        "payment_scheme": "FPS",
        "payment_type": "Credit",
        "processing_date": "2017-01-18",
        "reference": "Payment for Em's piano lessons",
        "scheme_payment_sub_type": "InternetBanking",
        "scheme_payment_type": "ImmediatePayment",
        "sponsor_party": {
          "account_number": "56781234",
          "bank_id": "123123",
          "bank_id_code": "GBDSC"
        }
      }
    }
    """
    Then response contains transaction with id 4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43
    Then request to list transactions returns 1 transaction

  Scenario: transaction-processor responds with success json when deleting a transaction
    Given a delete by id request for id 4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43
    Then response contains json
    """
    {"status":200,"message": "OK"}
    """

  Scenario: transaction-processor responds with exception json when deleting a missing transaction
    Given a delete by id request for id 4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43
    Then response contains json
    """
    {"errorCode":404,"message":"Could not find transaction with id: 4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43"}
    """

  Scenario: transaction-processor responds with no data when all transactions are deleted
    Given a deleteAll request
    Then response contains json
    """
    {"data":[]}
    """

  Scenario: transaction-processor responds with updated transaction
    Given a create request with data:
    """
    {
      "type": "Payment",
      "id": "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43",
      "version": 0,
      "organisation_id": "743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb"
    }
    """
    When updating a request with data:
    """
    {
      "type": "Payment",
      "id": "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43",
      "version": 0,
      "organisation_id": "some-updated-org-id"
    }
    """
    Then request to list transactions returns transaction with organisationId: some-updated-org-id
