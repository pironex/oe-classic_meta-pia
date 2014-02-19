# Image for piAx-AM3517 with QTembedded and support for 3D
# + additional stuff for KACO EMS

IMAGE_LINGUAS = "de-de en-us"

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard \
"

ANGSTROM_EXTRA_INSTALL ?= ""
#SPLASH = "exquisite exquisite-themes exquisite-theme-angstrom"

BAD_RECOMMENDATIONS = "avahi-daemon avahi-autoipd"

export IMAGE_BASENAME = "piax-kaco-image"

DEPENDS = "\
	task-base \
	task-pia-extended \
	task-pia-qte \
	task-pia-lcd \
	task-pia-kaco \
"

IMAGE_INSTALL = "\
	task-base \
	task-pia-extended \
	task-pia-qte \
	task-pia-lcd \
	task-pia-kaco \
	${ANGSTROM_EXTRA_INSTALL} \
"
#    ${XSERVER}
#    ${SPLASH}

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += 'install_linguas; ${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'
#PREFERRED_PROVIDER_virtual/kernel = linux-pia-kaco
#PREFERRED_VERSION_virtual/kernel = 3.2.29
#PREFERRED_VERSION_linux-omap = "3.2.29"

inherit image
