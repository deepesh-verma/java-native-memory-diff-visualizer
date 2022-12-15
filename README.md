# Java native memory diff visualizer 

## How to use

- Compile the java class
    ```
    javac TestApp.java
    ```

- Run the class file with native memory tracking enabled
    ```
    java -XX:NativeMemoryTracking=detail -Xms128M -Xmx128M -XX:MaxDirectMemorySize=1024M TestApp
    ```

- In a new terminal find the process Id using below command 
    ```
    jps
    ```

- Once the java process is running with native memory tracking enabled, run below command 
    ```
    ./log-native.sh $PID $INTERVAL
    ```
    where $PID is the java process id and $INTERVAL is the interval at which native memory detail would be taken 

- Create a csv file with the log from console 

- Open `report.html` file in a browser and upload the csv file


### Useful Gist - https://gist.github.com/prasanthj/48e7063cac88eb396bc9961fb3149b58
