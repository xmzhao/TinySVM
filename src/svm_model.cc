#include "common.h"
#include "misc.h"
#include "model.h"
#include "example.h"
#include "base_example.h"
#include "kernel.h"
#include "param.h"

// $Id: svm_model.cc,v 1.8 2001/01/16 21:14:20 taku-ku Exp $;

const char *help_message = "\nUsage: svm_model [options] model-file\n\n\
options:\n\
  -n, --sv-num             show number of Support Vectors.\n\
  -b, --bsv-num            show number of bounded Support Vectors.\n\
  -l, --loss               show L1 loss. (Empirical Risk.)\n\
  -t, --training-size      show the size of original trainig data\n\
      --training-num\n\
  -m, --margin             show estimated margin.\n\
  -d, --vc-dimension       show estimated VC dimension.\n\
  -x, --xi-alpha           show estimated xi-alpha value.\n\
  -X, --xi-alpha-rho=FLOAT set FLOAT for rho of xi-alpha estimator.\n\
                           (default 2.0).\n\
  -v, --version            show the version of TinySVM and exit.\n\
  -h, --help               show this help and exit.\n ";

static const char *short_options = "nmdxX:btlvh";

static struct option long_options[] = {
  {"sv-num",        no_argument,       NULL, 'n'},
  {"margin",        no_argument,       NULL, 'm'},
  {"vc-dimension",  no_argument,       NULL, 'd'},
  {"xi-alpha",      no_argument,       NULL, 'x'},
  {"xi-alpha-rho",  required_argument, NULL, 'X'},
  {"bsv-num",       no_argument,       NULL, 'b'},
  {"training-size", no_argument,       NULL, 't'},
  {"training-num",  no_argument,       NULL, 't'},
  {"loss",          no_argument,       NULL, 'l'},
  {"version",       no_argument,       NULL, 'v'},
  {"help",          no_argument,       NULL, 'h'},
  {NULL, 0, NULL, 0}
};

int
main (int argc, char **argv)
{
  int    all = 1;
  int    margin = 0;
  int    vcdim = 0;
  int    svnum = 0;
  int    xa = 0;
  int    bsv = 0;
  int    loss = 0;
  int    training_size = 0;
  double xa_rho = 2.0;

  extern char *optarg;

  while (1) {
    int opt = getopt_long (argc, argv, short_options, long_options, NULL);
    if (opt == EOF) break;

    switch (opt) {
    case 'n':
      all = 0; svnum = 1;
      break;
    case 'm':
      all = 0; margin = 1;
      break;
    case 'd':
      all = 0; vcdim = 1;
      break;
    case 'x':
      all = 0; xa = 1;
      break;
    case 'X':
      xa_rho = atof(optarg);
      break;
    case 'b':
      all = 0; bsv = 1;
      break;
    case 't':
      all = 0; training_size = 1;
      break;
    case 'l':
      all = 0; loss = 1;
      break;
    case 'v':
      fprintf (stdout, "%s of %s\n%s\n", argv[0], VERSION, COPYRIGHT);
      exit (EXIT_SUCCESS);
    case 'h':
      fprintf (stdout, "%s%s", COPYRIGHT, help_message);
      exit (EXIT_SUCCESS);
    default:
      fprintf (stdout, "%s\n", COPYRIGHT);
      fprintf (stdout, "Try `svm_model --help' for more information.\n");
      exit (EXIT_SUCCESS);
    }
  }

  if (argc < 2) {
    fprintf (stdout, "%s\n", COPYRIGHT);
    fprintf (stdout, "Try `svm_model --help' for more information.\n");
    exit (EXIT_FAILURE);
  }

  TinySVM::Model model;
  model.read (argv[argc - 1]);
  fprintf (stdout, "File Name:\t\t\t%s\n", argv[argc - 1]);

  if (all || margin)
    fprintf (stdout, "Margin:\t\t\t\t%g\n", model.estimateMargin ());
  if (all || svnum)
    fprintf (stdout, "Number of SVs:\t\t\t%d\n", model.getSVnum ());
  if (all || bsv) 
    fprintf (stdout, "Number of BSVs:\t\t\t%d\n", model.getBSVnum ());
  if (all || training_size) 
    fprintf (stdout, "Size of training data:\t\t%d\n", model.getTrainingDataSize());
  if (all || loss) 
    fprintf (stdout, "L1 Loss (Empirical Risk):\t%g\n", model.getLoss());
  if (all || vcdim)
    fprintf (stdout, "Estimated VC dimension:\t\t%g\n", model.estimateVC ());
  if (all || xa)
    fprintf (stdout, "Estimated xi-alpha(%g):\t\t%g\n", xa_rho,model.estimateXA(xa_rho));

  return EXIT_SUCCESS;
}
