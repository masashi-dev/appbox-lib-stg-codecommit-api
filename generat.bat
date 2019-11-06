del /Q C:\work\appbox\workspace\appbox-pf-stg-codecommit-common\appbox-platform-entity\src\main\java\jp\co\fnj\appbox\platform\entity\model\generat
del /Q C:\work\appbox\workspace\appbox-pf-stg-codecommit-common\appbox-platform-entity\src\main\java\jp\co\fnj\appbox\platform\entity\mapper\generat
del /Q C:\work\appbox\workspace\appbox-pf-stg-codecommit-common\appbox-platform-entity\src\main\resources\jp\co\fnj\appbox\platform\entity\mapper\generat

REM エンティティクラス自動生成
C:\work\appbox\tools\apache-maven-3.6.1\bin\mvn mybatis-generator:generate
