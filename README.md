## 麻酱社区
..........
## 资料
...........
## 工具
[github登录](github登录相关https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[github登录](github登录相关https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[github登录](github登录相关https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
## 脚本
```sql
CREATE CACHED TABLE PUBLIC.USER(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_CE9B0CAB_CA6A_4D41_B338_5783CFFD126A) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_CE9B0CAB_CA6A_4D41_B338_5783CFFD126A,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN CHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
)
```