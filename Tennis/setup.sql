ssh -i Gopu23.pem ec2-user@54.172.43.179
[ec2-user@ip-172-31-27-187 /]$ sudo -i
[root@ip-172-31-27-187 ~]# yum install docker

To find where docker is installed
[root@ip-172-31-27-187 ~]# rpm -ql docker

To Find docker version
[root@ip-172-31-27-187 ~]# rpm -qa docker

To start docker service
[root@ip-172-31-27-187 ~]# service docker start

To install Tomcat from docker
docker run -it -d tomcat:8.0
-d to run in background

to check process running in docker
docker ps -a

to kill services running in docker
docker rm -f 583699aeb65a

TO Scp file
scp -i Gopu23.pem D:\Software\Eclipse-2019-06\workspace\Git\Tennis\target\tennis.war ec2-user@54.172.43.179:/tmp

to deploy war
docker ps -a
   21  docker rm -f 1731ae6e919c
   24  docker run -it -p 8080:8080 -v tennis.war:/usr/local/tomcat/webapps/tennis.war -d tomcat:8.0
   
   docker run -it -p 8080:8080 -d tomcat:8.0
   
 to check if deploy file is copied
 [root@ip-172-31-27-187 tmp]# docker ps -a
[root@ip-172-31-27-187 tmp]# docker exec -it ec23aac47bae bash
root@ec23aac47bae:/usr/local/tomcat# ls -ltr

player
	playerid
	firstName
	lastName
	emailId
	phoneNumber
	Address
	sex
	photo
	level

Address
	streetAdress1
	streetAdress2
	city
	state
	country
	zip


match
	playerid1
	playerid2
	playerid3
	playerid4
	MatchTypeId
	result
	scoreid
	comments
	court_id
	scheduleid

scheudle
	date
	placeid
	status

court
	court id
	court name
	place
	active
	court type
	access type

	
tournamnet
tournament name
List<player_id>
prizer amount
winner
runner
List<Matches>

place
	name
	address


GameType
	singles
	mixed
	doubles
	
MatchType
	Reugular
	Tornament-league
	doubles-playOff

ResultType
	Completed
	notstarted
	notCompleted
	

score


playoff