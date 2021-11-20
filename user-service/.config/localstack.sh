#Executing SNS
awslocal sns create-topic --name new_user

# Executing SQS
awslocal sqs create-queue --queue-name local_dead_letter_queue;
awslocal sqs create-queue --queue-name local_queue --attributes '{ "RedrivePolicy": "{\"deadLetterTargetArn\":\"arn:aws:sqs:us-east-1:000000000000:local_dead_letter_queue\",\"maxReceiveCount\":\"2\"}" }'

# Subscribing the SNS to SQS
awslocal sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:new_user --protocol sqs --notification-endpoint http://localstack:4576/queue/local_queue