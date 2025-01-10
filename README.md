

## Configuration

1. Add your username and access key to the configuration file or environment variables as required.

## Running Tests in Parallel

To execute tests in parallel, use the following command:

```sh
mvn gauge:execute -DspecsDir=specs -DinParallel=true -Dnodes=4
```

- Replace `4` with the desired number of nodes based on the number of parallel specs you want to launch.
