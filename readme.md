# Watcher App - Demo

In the heart of a bustling metropolis lies a clandestine network of communication, guarded by the enigmatic figure known only as the "Communications Decryptor". With an arsenal of cutting-edge technology and unwavering determination, the Decryptor navigates through the labyrinth of encrypted messages to unveil the secrets hidden within.

Armed with the Device Provider and Message Decryptor, two invaluable allies in the battle against secrecy, the Decryptor sets out on a mission to decode the encrypted transmissions that traverse the digital realm. Their combined efforts serve as the linchpin in the fight against clandestine operations and clandestine agendas.

In one scenario, when handed a list of devices, each whispering their encrypted tales, the Decryptor springs into action. With swift precision, they sift through the devices, extracting only the most crucial messages from the cacophony of digital noise. Each message, a puzzle piece in a grand mosaic of intrigue, holds the key to unlocking a deeper truth.

## Run test

./gradlew test

## How to run on Docker

### Create Image

docker build -t watcher_app:0.0.1 .

### Run container

docker run -p 8080:8080 watcher_app:0.0.1