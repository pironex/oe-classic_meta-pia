#!/bin/sh

if ip route | grep default | grep ppp0 > /dev/null 2>&1 ; then
  echo Current default connection via GPRS:
  ip route | grep default | grep ppp0
elif ip route | grep default | grep eth0 > /dev/null 2>&1 ; then
  echo Current default connection via Ethernet:
  ip route | grep default | grep eth0
elif ip route | grep default | grep wlan0 > /dev/null 2>&1 ; then
  echo Current default connection via WLAN:
  ip route | grep default | grep wlan0
else
  echo Unknown default connection:
  ip route | grep default
fi

echo ""
echo "Configured IP addresses:"
ifconfig  | grep 'inet addr:'| grep -v '127.0.0.1' | cut -d: -f2 | awk '{ print "     "  $1}'

echo ""
