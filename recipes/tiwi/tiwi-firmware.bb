DESCRIPTION = "Firmwares for TiWi-R2 module"
LICENSE = "MIT"
PV = "2.6.37"
PR = "r003"

COMPATIBLE_MACHINE_pia-am35x = "pia-am35x"

SRC_URI = "file://firmwares/*"

S = "${WORKDIR}"

do_compile () {
    :
}

do_install () {
    install -d ${D}/lib/firmware/
    cp -RpP firmwares/* ${D}/lib/firmware/
    ln -s -T  wl127x-nvs.bin ${D}/lib/firmware/ti-connectivity/wl1271-nvs.bin
    cp ${D}/lib/firmware/ti-connectivity/* ${D}/lib/firmware/
}

FILES_${PN} += "/lib/firmware/*"
PACKAGE_ARCH = "all"
