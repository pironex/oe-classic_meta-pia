DESCRIPTION = "Additional packages for piA AM35x"
LICENSE = "MIT"
PR = "r034"

inherit task

RDEPENDS = ' \
	task-base \
	linux-firmware \
	pia-watchdog pia-led \
	\
	bc \
	bzip2 \
	coreutils \
	cron \
	dosfstools \
	iproute2 \
	less \
	mkfs-jffs2 \
	ntpdate \
	tar \
	tzdata tzdata-europe \
	\
	canutils \
	devmem2 \
	fbset fbset-modes \
	i2c-tools \
	lmsensors-apps lmsensors-sensors\
	mtd-utils \
	net-tools \
	openssl openssl-engines openssl-misc \
	picocom \
	procps \
	\
	links \
	nano \
	screen \
	\
	lighttpd lighttpd-module-cgi lighttpd-module-fastcgi \
	lighttpd-module-rewrite lighttpd-module-simple-vhost \
'

RRECOMMENDS = ' \
	util-linux-fsck \
	tiwi-firmware \
	iw wireless-tools ti-wifi-utils \
	rfkill 	wpa-supplicant \
	libgsm1 \
	ppp-gprs ppp ppp-tools \
        pia-gprs \
	sqlite3 \
	tslib-tests tslib-calibrate \
	kernel-module-g-serial \
	kernel-module-bluetooth kernel-module-hci-uart kernel-module-btwilnk \
	kernel-module-usbserial kernel-module-option \
	kernel-module-ppp-async kernel-module-ppp-generic \
	kernel-module-omap-aes kernel-module-omap-sham \
	kernel-module-n-gsm \
	kernel-module-dm9601 \
'
# 	kernel-modules