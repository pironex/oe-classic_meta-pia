# piA-AM3505 Image without graphical output

IMAGE_LINGUAS = "de-de en-us"

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard \
"

ANGSTROM_EXTRA_INSTALL ?= ""
#SPLASH = "exquisite exquisite-themes exquisite-theme-angstrom"

export IMAGE_BASENAME = "pia-extended-image"

DEPENDS = "\
	task-base \
	task-pia-extended \
	task-pia-lcd \
	task-pia-qte \
"

IMAGE_INSTALL = "\
	task-base \
	task-pia-extended \
	task-pia-lcd \
	task-pia-qte \
	${ANGSTROM_EXTRA_INSTALL} \
"
#    ${XSERVER} \
#    ${SPLASH} \

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += 'install_linguas; ${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

inherit image
