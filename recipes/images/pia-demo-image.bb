# Demo image for beagleboard

IMAGE_LINGUAS = "de-de fr-fr en-gb en-us pt-br es-es kn-in ml-in ta-in"

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard \
"

ANGSTROM_EXTRA_INSTALL ?= ""
SPLASH = "exquisite exquisite-themes exquisite-theme-angstrom"

export IMAGE_BASENAME = "pia-demo-image"

DEPENDS = "task-base"
IMAGE_INSTALL = "\
    ${XSERVER} \
    ${ANGSTROM_EXTRA_INSTALL} \
    task-beagleboard-demo \
    ${SPLASH} \
    "

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += 'install_linguas; ${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

inherit image
