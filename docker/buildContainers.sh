#!/usr/bin/env bash
docker build -t="southsidesoft/elasticsearch" ./elasticsearch
docker build -t="southsidesoft/rabbitmq" ./rabbitmq
