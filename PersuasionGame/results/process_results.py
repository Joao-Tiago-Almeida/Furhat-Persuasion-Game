import os
from numpy import float64, int64
import pandas as pd
import matplotlib.pyplot as plt
from pandas.core.series import Series
import matplotlib.patches as mpatches

def get_data():

    results = {}
    folder = "PersuasionGame/results/outputs/"

    for file in os.listdir(folder):

        if file.find(".txt") == -1:
            continue

        with open(folder+file, 'r') as f:
            info = f.readlines()
            
        for s in range(len(info)):
            fields = info[s].replace("\n","").split(": ")

            if fields[0] == '' or fields[0] == ' ': continue
            if fields[1] == "null": break

            try:
                fields[1] = int(fields[1])
            except ValueError:
                pass
            
            try:
                results[fields[0]].append(fields[1])
            except KeyError: 
                results[fields[0]] = [fields[1],]

    return results

def plot_unhetical_decisions_per_mode(df, title:str):

    df2 = pd.DataFrame(dtype=int64)
    
    for mode in df["Robot mode"].unique():

        if len(list(df[df["Robot mode"]==mode]["Unethical decisions"])) >  len(df2):
            for _ in range(len(list(df[df["Robot mode"]==mode]["Unethical decisions"]))-len(df2)):
                df2 = df2.append(pd.Series(dtype=int64), ignore_index=True)


        df2[mode] = pd.Series(list(df[df["Robot mode"]==mode]["Unethical decisions"]))

    df2 = df2.reindex(sorted(df2.columns, reverse=True), axis=1)

    fig = plt.figure()
    fig.suptitle("Relation Between Unethical Decisions taken per Robot Mode")
    boxplot = df2.boxplot(grid=True, rot=0)
    boxplot.set_title(title)
    boxplot.set_ylabel("Number of Unethical Decisions")

    leg = []
    for mode in sorted(list(df["Robot mode"].unique()), reverse=True):
        leg.append(
            mpatches.Patch(label =f'{mode}: {df2[mode].mean():.1f}')
        )
    
    boxplot.legend(handles=leg, loc=2)
    boxplot.get_legend().set_title("Average Number of\nUnethical Desicions")

    fig.savefig(f'PersuasionGame/results/unethical_mode_[{title.replace(" ","_").lower()}].png')

    breakpoint

def plot_mode_distribution(df):

    index = sorted(df['Robot mode'].unique(), reverse=False)
    remote = list(df[df['Conditions']=="Virtual"]['Robot mode'].value_counts().sort_index(ascending=False))
    in_person = list(df[df['Conditions']=="In Person"]['Robot mode'].value_counts().sort_index(ascending=False))

    df2 = pd.DataFrame(
        {'Remote': remote, "In Person": in_person},
        index = index
    )

    df2.plot.bar(
        rot=0, 
        xlabel="", 
        ylabel="Occurances", 
        legend=True, 
        stacked=True,
        title="Number of experiments performed with each Robot mode" ,
        ).get_figure().savefig(f'PersuasionGame/results/occurrences_mode.png')

    breakpoint


if __name__ == "__main__":

    data = get_data()

    df = pd.DataFrame.from_dict(data)

    plot_unhetical_decisions_per_mode(df[df["Conditions"]=="In Person"], "(In Person Experiments)")

    plot_unhetical_decisions_per_mode(df[df["Conditions"]=="Virtual"], "(Remote Experiments)")

    plot_unhetical_decisions_per_mode(df, "(All Experiments)")
    plot_mode_distribution(df)

    print(f'Number of experiments performed: {len(df)}.')

    breakpoint