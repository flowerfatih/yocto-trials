DESCRIPTION = "Simple helloworld application"
LICENSE = "MIT"

#to make sure that license text has not changed otherwise throw an error
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#Define where to source files are. this is required for fetching.
SRC_URI = "file://userprog.c"

#S variable controls the directory that has the extracted files
S = "${WORKDIR}"


do_compile() {
	${CC} userprog.c ${LDFLAGS} -o userprog
}	
do_install() {
	install -d ${D}${bindir}
	install -m 0755 userprog ${D}${bindir}
}
