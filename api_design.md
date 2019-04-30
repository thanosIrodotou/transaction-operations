transactions-processor API Design
---
<table>
  <tr>
    <th>Verb</th>
    <th>Path</th>
    <th>Body</th>
    <th>Description</th>
    <th>Success/Error Response</th>
  <tr>
    <td>GET</td>
    <td>/v1/transactions</td>
    <td/>
    <td>Returns a list of transactions</td>
    <td>On success: 200<br/>On failure: 500 </td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/v1/transactions/{id}</td>
    <td/>
    <td>Returns a specific transaction given an id</td>
    <td>On success: 200<br/>On failure:<br/>
<pre>
{
  "errorCode": 404,
  "message": "Could not find transaction with id: {id}"
}
</pre>
    </td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/v1/transactions</td>
    <td>Valid Transaction JSON payload</td>
    <td>Creates a new transaction</td>
    <td>On success: 200<br/>On failure:<br/>
<pre>
{
  "timestamp": {timestamp},
  "status": 400,
  "error": "Bad Request",
  "message": "{errorMessage}",
  "path": "/v1/transactions/"
}
</pre>
      On duplicate:<br/>
<pre>
{
  "errorCode": 409,
  "message": "Transaction with id: {id} already exists"
}
</pre>
    </td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/v1/transactions/{id}</td>
    <td>Valid Transaction JSON payload</td>
    <td>Updates an existing transaction given an id</td>
    <td>On success: 200<br/>On failure:<br/>
<pre>
{
  "errorCode": 404,
  "message": "Could not find transaction with id: {id}"
}    
</pre>
    </td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/v1/transactions/{id}</td>
    <td></td>
    <td>Deletes an existing transaction given an id</td>
    <td>On success: 200<br/>On failure:<br/>
<pre>
{
  "errorCode": 404,
  "message": "Could not find transaction with id: {id}"
}    
</pre>
    </td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/v1/transactions</td>
    <td></td>
    <td>Deletes all transactions</td>
    <td>On success: 200<br/>On failure: 500<br/>
    </td>
  </tr>
</table>
