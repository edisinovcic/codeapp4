**Backend used for CodeApp4 competition**


Start by running sh start-docker.sh

If port is not available, kill the process on it by:
fuser -k 5432/tcp

Then:
if lsof -i:5432
return something, then you are good to go.
