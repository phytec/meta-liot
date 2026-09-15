SRC_URI:append = " \
    git://git@github.com/ML-PA-Consulting-GmbH/phyhub-liot-device-seeding.git;branch=main;protocol=ssh;name=seed \
"

SRCREV_seed = "77097569bfb07ac70a9d3afee6e009d02eed87e2"

copy_constants_go () {
    cp ${S}/src/github.com/snapcore/snapd/phyhub-production-environment/constants.go ${S}/constants/constants.go
}

python do_patch:append () {
    bb.build.exec_func("copy_constants_go", d)
}
