PR_append = "+pia021"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
#version with itbok
#SRCREV_pia-am35x = "97cc8c3e84c6d75446ff59cd1875ceee11afc0bd"
#version without itbok
#SRCREV_pia-am35x = "2bb376029ccea6a0b7670dc0df25b56e95fcb03f"
#SRCREV_pia-am35x = "7569af0e09534b8b9f66551de56fff813cace770"
# pia012
#SRCREV_pia-am35x = "681c30c80231ef926b6e54493c7f1a13ed2f10c5"
# pia013
#SRCREV_pia-am35x = "a5854c13cbd2c31f99e15e7c0dc9f0520c585818"
#PV_pia-am35x = "2012.07rc1+${PR}+gitr${SRCREV}"
# KACO EMS Rev 0.3
#SRCREV_pia-am35x = "65893fb023fa48347a890c4e565fc4bc1cce453b"
# pia016
#SRCREV_pia-am35x = "a5854c13cbd2c31f99e15e7c0dc9f0520c585818"
# pia017 new ems-io, 5V changes
#SRCREV_pia-am35x = "7f0acccc8bac91baf82f93a5c5ba4cb2986704df"
# pia018 new boot command line, ro quiet
#SRCREV_pia-am35x = "808d85ae0fa0beb618a2d9d7fb58a03659881b4f"
# pia019 uart bugfixes + messverstaerker support
#SRCREV_pia-am35x = "38df447ff182ab132baac76b2b755881b796abbf"
# pia021 musb kernel parameter fixes
SRCREV_pia-am35x = "5bba93a06c5374065332cf901dca91ccc73cd549"
SRC_URI_pia-am35x = "git://192.168.1.90/uboot/uboot-pia-bk.git;branch=pia35x-release;protocol=git"
PV_pia-am35x = "2012.07+${PR}+gitr${SRCREV}"

UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"

MLO_BINARY = "MLO"
MLO_IMAGE = "MLO-${MACHINE}-${PV}-${PR}"



do_install_append_pia-am35x() {
	install ${S}/${MLO_BINARY} ${D}/boot/${MLO_IMAGE}
	ln -sf ${MLO_IMAGE} ${D}/boot/${MLO_BINARY}
}

do_deploy_append_pia-am35x() {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/${MLO_BINARY} ${DEPLOY_DIR_IMAGE}/${MLO_IMAGE}
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${MLO_IMAGE}
}
