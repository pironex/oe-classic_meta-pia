require linux.inc
DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE_pia-am35x = "pia-am35x"

PV = "2.6.37"
#SRCREV = "6696c75a499ac4fc586a47f2c73d2351844e21bd"
# 2012-02
#SRCREV = "46de1f56694734a26cd0dd50f5debb1467c97600"
# 2012-04
#SRCREV = "b79b867af312a498ef26dca52f4333a19b3c93b6"
# 2012-05 EMS patches
#SRCREV = "684a638e2f4c80c55f44d5e52a3e12f843ea4e90"
# 2012-06
#SRCREV = "3044edadc4435da35ad540e7709e4b2add908d8c"
#MACHINE_KERNEL_PR_append = "pia013+gitr${SRCREV}"
# 2012-06a kako io changes
#SRCREV = "fab625c6d2ae9c0885d6a08495166f6ea37152d1"
# bugfixes + CMUX
#SRCREV = "1d29c6909cd7b5eb2c4fd8d652a977145f8c2fcd"
#MACHINE_KERNEL_PR_append = "pia018+gitr${SRCREV}"
# KACO fixes RS485
#SRCREV = "a51338330baf7d22f9c9c0456fce5c775521c0d8"
#MACHINE_KERNEL_PR_append = "pia019+gitr${SRCREV}"
# KACO EMS Rev 0.3
#SRCREV = "633c159a1d91f85a33315b14dee0727d70ad87d2"
#MACHINE_KERNEL_PR_append = "pia020+gitr${SRCREV}"
# pia_release_201212
#SRCREV = "120a570b7df2071f78f2ae3e15109a16e523d99f"
#MACHINE_KERNEL_PR_append = "pia022+gitr${SRCREV}"
SRCREV = "eabb17213f5cc0921f78ee744a4993a8c118063c"
MACHINE_KERNEL_PR_append = "pia024+gitr${SRCREV}"

# workaround for older OE:
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATHPKG_prepend := "config-2.6.37:"
#FILESPATHBASE_prepend := "${THISDIR}/config:${THISDIR}/patches:"
# add out config files path to the search path
# this works only for oe-core (new layered OE)
#FILESEXTRAPATHS := "${THISDIR}/${PN}"
#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://192.168.1.90/kernel/linux-pia-bk.git;branch=master-pia35x-2.6.37;protocol=git \
           file://defconfig \
           file://files/logo_linux_clut224.ppm \
"

#module_autoload_g_serial = "g_serial"

#SRC_URI_append_pia-am35x = "\
#    file://patches/0001-master_to_pia_testing_ems.patch "

#S = "${WORKDIR}/linux-omap-2.6"
S = "${WORKDIR}/git"

do_configure_prepend() {
	cp ${WORKDIR}/files/logo_linux_clut224.ppm ${WORKDIR}/git/drivers/video/logo/ 
}