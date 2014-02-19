PR_append = "+7"

# workaround for older OE:
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATHBASE_prepend := "${THISDIR}/netbase:"
