javac -d bin -cp "libs/*" src/jogo/*.java  

jar cfm target/app.jar MANIFEST.MF -C bin .

java -jar target/app.jar