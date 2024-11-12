#!/bin/bash
test $(curl 54.180.146.200:8765?a=1\&b=2) -eq 2
