#!/bin/sh

if [ -e /run ] && /bin/mountpoint -q /run ; then
  mount -t tmpfs,mode=755 tmpfs /run &&  mkdir /run/shm
fi
if [ -e /proc ] && ! [ -e /proc/mounts ]; then
  mount -t proc proc /proc
fi

if [ -e /sys ] && ! [ -e /sys/kernel ] && grep -q sysfs /proc/filesystems; then
  mount sysfs /sys -t sysfs
fi

exit 0
