#!/bin/bash

# Curl command to get current accounts transactions
# Filters to one account (ACC-001992310) and includes transactions from 2025-12-11 to 2025-12-15

curl -X GET "http://localhost:8080/v1/current-accounts/transactions?fromDate=2025-12-11&toDate=2025-12-15&accountList=ACC-001992310&includeTransactions=true" \
  -H "customerID: 87234199" \
  -H "Content-Type: application/json"

echo ""
echo "---"
echo ""

# Curl command to get foreign current accounts transactions
# Filters by currency (USD), includes transactions from 2025-12-11 to 2025-12-15
# Currency filter is optional - if not provided, includes all currencies

curl -X GET "http://localhost:8080/v1/foreign-current-accounts/transactions?fromDate=2025-12-11&toDate=2025-12-15&currencyList=USD&includeTransactions=true" \
  -H "customerID: 87234199" \
  -H "Content-Type: application/json"

echo ""
echo "---"
echo ""

# Curl command to get deposits
# Filters by nickname "kids fund" (case-insensitive), includes transactions

curl -X GET "http://localhost:8080/v1/deposits?asOfDate=2025-12-18&nicknameFilter=kids%20fund&includeTransactions=true" \
  -H "customerID: 87234199" \
  -H "Content-Type: application/json"

echo ""
echo "---"
echo ""

# Curl command to get credit cards transactions
# Filters by last 4 digits (8891), includes transactions from 2025-12-11 to 2025-12-15

curl -X GET "http://localhost:8080/v1/credit-cards/transactions?fromDate=2025-12-11&toDate=2025-12-15&last4Digits=8891&includeTransactions=true" \
  -H "customerID: 87234199" \
  -H "Content-Type: application/json"
