const { receiveMessage, deleteMessage } = require("./sqsClient");
require("dotenv").config();

(async () => {
  while (true) {
    console.log("Reading...");
    const messages = await receiveMessage();
    for (const msg of messages) {
      console.log("Deleting... ", JSON.parse(msg.Body).Message);
      deleteMessage(msg.ReceiptHandle);
    }
  }
})();
