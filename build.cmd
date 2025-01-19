javac -d bin -cp "libs/*" src/jogo/*.java  

@REM java -jar cfr.jar libs/jplay.jar --outputdir ./bin/jplay

jar xf libs/jplay.jar

move jplay bin

jar cfm target/app.jar MANIFEST.MF -C bin .

java -jar target/app.jar