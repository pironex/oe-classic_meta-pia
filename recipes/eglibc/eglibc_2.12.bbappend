THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATHBASE_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://allow_build_with_make4.patch "

PR_append = "+pia001"
