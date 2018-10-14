# spring-boot-versioning-sample1
Versioning of Rest Endpoint with spring boot sample 1

To check the output with versioning,
```
curl -H "X-Protocol-Version:1" http://localhost:8080/user/1
curl -H "X-Protocol-Version:2" http://localhost:8080/user/1
curl -H "X-Protocol-Version:3" http://localhost:8080/user/0
```
