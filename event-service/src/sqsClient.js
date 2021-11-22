var {
  SQSClient,
  ReceiveMessageCommand,
  DeleteMessageCommand,
} = require("@aws-sdk/client-sqs");

const client = new SQSClient({
  apiVersion: "2012-11-05",
  region: process.env.AWS_REGION,
  endpoint: process.env.SQS_ENDPOINT,
});

async function receiveMessage() {
  var params = {
    MaxNumberOfMessages: 10,
    QueueUrl: process.env.AWS_QUEUE_URL,
    VisibilityTimeout: 20,
    WaitTimeSeconds: 20,
  };
  console.log("start receive message");
  const command = new ReceiveMessageCommand(params);
  try {
    const response = await client.send(command);
    return response.Messages ? response.Messages : [];
  } catch (err) {
    console.error(err);
    return [];
  }
}

async function deleteMessage(receiptHandle) {
  var deleteParams = {
    QueueUrl: process.env.AWS_QUEUE_URL,
    ReceiptHandle: receiptHandle,
  };
  const command = new DeleteMessageCommand(deleteParams);
  return await client.send(command);
}

module.exports = { receiveMessage, deleteMessage };
