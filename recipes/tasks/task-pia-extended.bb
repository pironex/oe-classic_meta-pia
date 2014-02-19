DESCRIPTION = "Additional demos and utility packages for piA AM35x that require more space. Can be uninstalled."
LICENSE = "MIT"
PR = "r012"

inherit task

# we don't depend on task-base-extended, as we don't want bluetooth or wifi by default
# TODO create special task for them and an image if necessary
RDEPENDS = ' \
	task-pia \
	task-base \
	usbutils \
'

# packages required for expansion boards, display
RRECOMMENDS = ' \
	man man-doc \
	canutils-doc \
	gdb-doc \
	i2c-tools-doc \
	iproute2-doc \
	iw-doc \
	lighttpd-doc \
	links-doc \
	lmsensors-apps-doc \
	mc-doc \
	memtester-doc \
	minicom \
	mtd-utils-doc \
	openvpn-doc \
	picocom-doc \
	powertop-doc \
	ppp-doc \
	tar-doc \
	vim-doc \
	wpa-supplicant-doc \
	\
	perl perl-module-posix perl-module-exporter-heavy perl-module-fcntl \
	mc \
	openvpn \
	vim \
	\
	lmbench \
	mbw \
	memtester \
	powertop latencytop iotop \
	dbus-cxx dbus-x11 \
	dbus-c++ \
	\
	gdb gdbserver \
	kernel-module-rtlwifi kernel-module-rtl8192c-common kernel-module-rtl8192cu \
	kernel-module-rt2x00lib kernel-module-rt2x00usb \
	kernel-module-rfcomm kernel-module-rfkill \
'
#bigbuckbunny-480p \
# 	kernel-modules