THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATHBASE_prepend := "${THISDIR}/file:"

SRC_URI_append = " file://native_magic_version_fix.patch "

PR_append = "+pia002"
