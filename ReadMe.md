docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -v /home/rathod/MysqlData:/var/lib/mysql --name mysqlserver mysql
